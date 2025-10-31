## Level 1 – Beginner

### Q1. What is API testing?
**Answer:**  
API testing verifies that an application's endpoints return the correct responses, handle data properly, and integrate correctly. It focuses on request/response validation rather than UI.

---

### Q2. What are common HTTP methods and tools used in API testing?
**Answer:**  
**Methods:** GET, POST, PUT/PATCH, DELETE  
**Tools:** Postman, cURL, RestAssured, Python `requests` library.

---

### Q3. Describe the basic structure and purpose of an API.
**Answer:**  
An API defines communication between software components through **endpoints**, **methods**, **headers**, and **payloads**.  
It exposes functions or data for integration or automation.

---

### Q4. Perform a simple GET request using Python.
```python
import requests

def test_get_users():
    response = requests.get("https://reqres.in/api/users?page=2")
    assert response.status_code == 200
    print(response.json()["data"][0]["email"])
```

---

### Q5. How to send a POST request with JSON payload?
```python
payload = {"name": "morpheus", "job": "leader"}
response = requests.post("https://reqres.in/api/users", json=payload)
assert response.status_code == 201
```

---

### Q6. What are HTTP status codes and their meanings?
| Code | Meaning |
|------|----------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Internal Server Error |

---

### Q7. How to handle JSON responses in tests?
```python
data = response.json()
assert "id" in data
assert data["name"] == "morpheus"
```

---

### Q8. Types of API testing
**Answer:**  
- Functional testing  
- Performance testing  
- Security testing  
- Compatibility testing

---

## Level 2 – Intermediate

### Q1. How can pytest be used for API testing?
**Answer:**  
You can organize API test cases as pytest functions with assertions and fixtures.

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

### Q2. How do you debug an API returning 500 Internal Server Error?
**Answer:**  
- Verify if the issue persists across retries.  
- Try different inputs to check for data issues.  
- Review API/server logs for stack traces.  
- Test in other environments (QA/Staging/Prod).  
- Discuss findings with developers to debug further.

---

### Q3. How to handle REST and SOAP APIs, and work with JSON or XML?
**Answer:**  
- Use `requests` for REST APIs (JSON).  
- Use libraries like `zeep` for SOAP APIs (XML).  
- Parse responses using `response.json()` or `xml.etree.ElementTree`.

---

### Q4. How do you manage environment-specific configurations?
**Answer:**  
Use environment variables or config files (YAML/JSON).

```python
import os
BASE_URL = os.getenv("BASE_URL", "https://reqres.in/api")
```

---

### Q5. How to handle dynamic values like timestamps or tokens?
**Answer:**  
- Extract values dynamically (e.g., `response.json()['token']`).  
- Compare timestamps within a range, not exact values.  
- Reuse tokens across requests in variables or fixtures.

---

### Q6. How to test API security vulnerabilities?
**Answer:**  
- Remove or alter auth headers to test unauthorized access.  
- Inject SQL commands in parameters to detect SQL Injection.  
- Check for sensitive data exposure (passwords, keys).  
- Test for XSS and CSRF vulnerabilities.

---

### Q7. How do you test APIs that process large data?
**Answer:**  
- Send large payloads to test limits.  
- Monitor for timeouts and performance degradation.  
- Analyze memory usage using tools like JMeter.  
- Verify data integrity and response time expectations.

---

### Q8. How can you validate API responses using schema?
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

### Q9. How to mock API responses?
**Answer:**  
Use the `responses` or `requests-mock` library.

```python
import responses

@responses.activate
def test_mock_api():
    responses.add(responses.GET, "https://api.test/mock", json={"result": "ok"}, status=200)
    res = requests.get("https://api.test/mock")
    assert res.json()["result"] == "ok"
```

---

### Q10. Best practices for API testing
**Answer:**  
- Follow the testing pyramid (unit → integration → E2E).  
- Shift left — test early and often.  
- Keep tests independent and data-driven.  
- Validate both positive and negative scenarios.

---

## Level 3 – Expert

### Q1. How do you design an API automation framework?
**Answer:**  
Key components:  
- Config management (URLs, credentials)  
- Reusable API client wrapper  
- Schema validation module  
- Logging and report generation  
- CI/CD integration for execution

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
```python
def test_create_and_get_user(base_url):
    create_res = requests.post(f"{base_url}/users", json={"name": "Neo"})
    user_id = create_res.json()["id"]
    get_res = requests.get(f"{base_url}/users/{user_id}")
    assert get_res.status_code == 200
```

---

### Q3. How do you handle retries for unstable endpoints?
```python
from requests.adapters import HTTPAdapter, Retry

session = requests.Session()
retries = Retry(total=3, backoff_factor=1)
session.mount("https://", HTTPAdapter(max_retries=retries))
res = session.get("https://reqres.in/api/users/2")
```

---

### Q4. How do you parallelize API tests?
Use `pytest-xdist` for concurrent runs.
```bash
pytest -n 4
```

---

### Q5. How to integrate API tests in CI/CD?
- Include pytest command in CI pipelines.  
- Generate and upload test reports.  
- Use exit codes for pass/fail status.

```bash
pytest --html=report.html --self-contained-html
```

---

### Q6. How to perform negative API testing?
**Answer:**  
- Test invalid inputs and missing parameters.  
- Validate error codes (400, 404, 500).  
- Ensure error messages are clear and accurate.

---

### Q7. How to secure API credentials in tests?
**Answer:**  
- Use environment variables or secret managers.  
- Never commit secrets to Git.  
- Load sensitive data dynamically via `.env`.

---

### Q8. How to test API performance and scalability?
**Answer:**  
- Use tools like JMeter, Locust, or k6.  
- Measure response times, throughput, and error rates.  
- Analyze server behavior under load.

---

### Q9. Explain common API testing challenges and how to overcome them.
**Answer:**  
- **Dynamic data:** use variable extraction.  
- **Flaky endpoints:** add retries or mocks.  
- **Authentication:** centralize token management.  
- **Versioning:** maintain backward compatibility tests.

---

### Q10. Best practices for scalable API test automation.
**Answer:**  
- Keep tests modular and maintainable.  
- Use fixtures for setup/teardown.  
- Separate data, logic, and configuration.  
- Integrate with CI/CD.  
- Implement schema validation and logging.
