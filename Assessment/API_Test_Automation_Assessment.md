## Level 1 – Beginner

### Q1. What is API testing?
**Answer:**  
API testing verifies that an application's endpoints return the correct responses, handle data properly, and integrate correctly. It focuses on request/response validation rather than UI.

---

### Q2. What are common HTTP methods used in API testing?
**Answer:**  
- **GET:** Retrieve data  
- **POST:** Create new data  
- **PUT/PATCH:** Update existing data  
- **DELETE:** Remove data  

---

### Q3. Perform a simple GET request using Python.
**Answer:**
```python
import requests

def test_get_users():
    response = requests.get("https://reqres.in/api/users?page=2")
    assert response.status_code == 200
    data = response.json()
    print(data["data"][0]["email"])
```

---

### Q4. How to send a POST request with JSON payload?
**Answer:**
```python
payload = {"name": "morpheus", "job": "leader"}
response = requests.post("https://reqres.in/api/users", json=payload)
assert response.status_code == 201
```

---

### Q5. How to validate JSON fields in response?
**Answer:**
```python
data = response.json()
assert data["name"] == "morpheus"
assert "id" in data
```

---

### Q6. What are HTTP status codes and their meanings?
**Answer:**  
| Code | Meaning |
|------|----------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Internal Server Error |

---

## Level 2 – Intermediate

### Q1. How can pytest be used for API testing?
**Answer:**  
You can organize API test cases as pytest functions with assertions and fixtures for setup.

```python
import pytest, requests

@pytest.fixture
def base_url():
    return "https://reqres.in/api"

def test_list_users(base_url):
    res = requests.get(f"{base_url}/users?page=2")
    assert res.status_code == 200
    assert "data" in res.json()
```

---

### Q2. How do you pass headers and authentication tokens?
**Answer:**
```python
headers = {"Authorization": "Bearer <token>"}
res = requests.get("https://api.example.com/data", headers=headers)
assert res.status_code == 200
```

---

### Q3. Explain how to parametrize API tests.
**Answer:**
```python
@pytest.mark.parametrize("user_id", [1, 2, 3])
def test_get_user(base_url, user_id):
    res = requests.get(f"{base_url}/users/{user_id}")
    assert res.status_code == 200
```

---

### Q4. How can you validate API responses using schema?
**Answer:**
```python
from jsonschema import validate

schema = {
    "type": "object",
    "properties": {
        "name": {"type": "string"},
        "job": {"type": "string"}
    },
    "required": ["name", "job"]
}

validate(instance={"name": "John", "job": "Dev"}, schema=schema)
```

---

### Q5. How to mock API responses in tests?
**Answer:**
Using the `responses` library:

```python
import responses, requests

@responses.activate
def test_mock_api():
    responses.add(
        responses.GET,
        "https://api.test/mock",
        json={"result": "ok"}, status=200
    )
    res = requests.get("https://api.test/mock")
    assert res.json()["result"] == "ok"
```

---

### Q6. How do you manage environment-specific configurations?
**Answer:**
Use YAML/JSON config files or environment variables.

```python
import os

BASE_URL = os.getenv("BASE_URL", "https://reqres.in/api")
```

---

### Q7. How do you log API request and response data?
**Answer:**
```python
import logging
logging.basicConfig(level=logging.INFO)
logging.info(f"Request URL: {url}")
logging.info(f"Response: {response.text}")
```

---

## Level 3 – Expert

### Q1. How do you design an API automation framework?
**Answer:**  
Key components:  
- Config management (base URL, credentials)  
- Reusable API client module  
- Pytest-based test organization  
- Schema validation utilities  
- Logging & reporting integration  
- CI/CD pipeline setup

Example structure:
```
api_framework/
│-- tests/
│-- utils/
│-- config/
│-- conftest.py
│-- requirements.txt
```

---

### Q2. How do you chain API requests?
**Answer:**
Use data from one API response in another request.

```python
def test_create_and_get_user(base_url):
    create_res = requests.post(f"{base_url}/users", json={"name": "Neo"})
    user_id = create_res.json()["id"]
    get_res = requests.get(f"{base_url}/users/{user_id}")
    assert get_res.status_code == 200
```

---

### Q3. How do you handle retries for unstable endpoints?
**Answer:**
Use `requests` retry adapters.

```python
from requests.adapters import HTTPAdapter, Retry

session = requests.Session()
retries = Retry(total=3, backoff_factor=1)
session.mount("https://", HTTPAdapter(max_retries=retries))
res = session.get("https://reqres.in/api/users/2")
```

---

### Q4. How do you parallelize API tests?
**Answer:**
Use `pytest-xdist` for parallel execution.

```bash
pytest -n 4
```

---

### Q5. How to integrate API tests in CI/CD?
**Answer:**
- Add pytest commands in Jenkins/GitHub workflow.  
- Store reports as artifacts.  
- Use exit codes for pipeline pass/fail.

```bash
pytest --html=report.html --self-contained-html
```

---

### Q6. Explain negative testing in APIs.
**Answer:**  
Negative tests ensure the API handles invalid inputs gracefully (e.g., 400, 404 errors).

```python
res = requests.get("https://reqres.in/api/users/9999")
assert res.status_code == 404
```

---

### Q7. How do you secure API credentials in automation?
**Answer:**  
- Use environment variables or secret vaults.  
- Avoid committing tokens to Git.  
- Use `.env` files with `python-dotenv`.

---

### Q8. How do you generate detailed API reports?
**Answer:**
Use pytest plugins like Allure or HTML reports.

```bash
pytest --alluredir=reports/allure-results
allure serve reports/allure-results
```

Or HTML:
```bash
pytest --html=report.html --self-contained-html
```

---

### Q9. Explain the role of JSON schema validation in test automation.
**Answer:**  
Schema validation ensures response structure matches contract — prevents integration failures early.

---

### Q10. Best practices for scalable API test automation.
**Answer:**  
- Modular design and clear folder structure  
- Use fixtures for setup  
- Separate data and logic  
- Implement retries and schema validation  
- Integrate with CI/CD and version control  
- Use reporting and logging consistently
