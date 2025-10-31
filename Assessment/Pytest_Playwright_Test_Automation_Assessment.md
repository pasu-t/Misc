## Level 1 – Beginner

### Q1. What is pytest and why is it popular for test automation?
**Answer:**  
`pytest` is a testing framework that simplifies writing small and scalable test cases.  
It supports fixtures, parametrization, plugins, and detailed reports — making it a preferred choice for Python test automation.

---

### Q2. How does pytest discover tests?
**Answer:**  
Pytest automatically discovers tests in files that:  
- Start with `test_` or end with `_test.py`  
- Contain functions or classes starting with `test_`

```bash
pytest tests/ -v
```

---

### Q3. Write a simple pytest test case.
**Answer:**
```python
def test_addition():
    assert 2 + 3 == 5
```

---

### Q4. Explain common pytest CLI options.
**Answer:**
| Option | Description |
|---------|-------------|
| `-v` | verbose output |
| `-s` | show print/log output |
| `-k <expr>` | run tests matching keyword |
| `-m <marker>` | run tests with specific marker |
| `--maxfail=2` | stop after 2 failures |

---

### Q5. What is Playwright, and how is it different from Selenium?
**Answer:**  
Playwright is a modern browser automation tool supporting Chromium, Firefox, and WebKit.  
Unlike Selenium, it offers faster execution, built-in waits, and headless mode with native parallelism.

---

### Q6. Write a simple Playwright test to open a webpage.
**Answer:**
```python
from playwright.sync_api import sync_playwright

def test_open_page():
    with sync_playwright() as p:
        browser = p.chromium.launch(headless=True)
        page = browser.new_page()
        page.goto("https://example.com")
        assert "Example Domain" in page.title()
        browser.close()
```

---

## Level 2 – Intermediate

### Q1. Explain pytest fixtures with example.
**Answer:**  
Fixtures provide reusable setup and teardown code.

```python
import pytest

@pytest.fixture
def setup_browser():
    print("Launching browser")
    yield
    print("Closing browser")

def test_example(setup_browser):
    print("Running test")
```

**Fixture scopes:** `function`, `class`, `module`, `session`

---

### Q2. What is fixture parametrization?
**Answer:**
Allows running a test with multiple data sets.

```python
@pytest.mark.parametrize("num,expected", [(2, 4), (3, 9)])
def test_square(num, expected):
    assert num * num == expected
```

---

### Q3. What are pytest markers? Give example.
**Answer:**
Markers are used to categorize or selectively run tests.

```python
import pytest

@pytest.mark.smoke
def test_login():
    assert True
```

Run with:
```bash
pytest -m smoke
```

---

### Q4. Explain Page Object Model (POM) in Playwright.
**Answer:**  
POM separates UI locators and actions into dedicated classes for maintainability.

```python
class LoginPage:
    def __init__(self, page):
        self.page = page
        self.username = page.locator("#username")
        self.password = page.locator("#password")
        self.login_btn = page.locator("#login")

    def login(self, user, pwd):
        self.username.fill(user)
        self.password.fill(pwd)
        self.login_btn.click()
```

---

### Q5. How to capture screenshots on test failure?
**Answer:**
```python
import pytest

@pytest.hookimpl(tryfirst=True, hookwrapper=True)
def pytest_runtest_makereport(item, call):
    outcome = yield
    rep = outcome.get_result()
    if rep.when == "call" and rep.failed:
        page = item.funcargs.get("page")
        if page:
            page.screenshot(path=f"screenshots/{item.name}.png")
```

---

### Q6. How do you run tests in parallel?
**Answer:**  
Use the `pytest-xdist` plugin:

```bash
pytest -n 4
```

Runs tests across 4 parallel workers.

---

### Q7. Explain Playwright’s locator strategy.
**Answer:**  
Playwright uses powerful locators like CSS, text, role, and test IDs.

```python
page.locator("text=Login").click()
page.locator("input[name='email']").fill("test@example.com")
```

It auto-waits for elements before interacting.

---

### Q8. How can you integrate pytest with CI/CD?
**Answer:**
- Add pytest to CI pipeline (e.g., GitHub Actions or Jenkins).  
- Generate reports (JUnit or HTML).  
- Example command:

```bash
pytest --junitxml=report.xml --html=report.html
```

---

## Level 3 – Expert

### Q1. Explain pytest hook functions and give an example.
**Answer:**
Hooks let you customize pytest’s behavior.

```python
def pytest_runtest_setup(item):
    print(f"Setting up {item.name}")
```

Common hooks:
- `pytest_configure(config)`
- `pytest_runtest_setup(item)`
- `pytest_runtest_makereport(item, call)`

---

### Q2. How do you manage browser context in Playwright?
**Answer:**
Use `context` to isolate sessions or reuse authentication.

```python
context = browser.new_context(storage_state="auth.json")
page = context.new_page()
```

Fixtures can handle setup and teardown for context reuse.

---

### Q3. Explain Playwright tracing and debugging tools.
**Answer:**
Playwright can record detailed execution traces:

```python
page.tracing.start(screenshots=True, snapshots=True)
# perform actions
page.tracing.stop(path="trace.zip")
```

You can view trace files using:
```bash
npx playwright show-trace trace.zip
```

---

### Q4. How can you handle flaky tests in Playwright?
**Answer:**
- Use **auto-waiting** and **retries**  
- Increase timeout only when needed  
- Implement retry logic:

```bash
pytest --reruns 2 --reruns-delay 3
```

---

### Q5. How to build a reusable browser fixture in pytest?
**Answer:**
```python
@pytest.fixture(scope="session")
def browser():
    from playwright.sync_api import sync_playwright
    p = sync_playwright().start()
    browser = p.chromium.launch()
    yield browser
    browser.close()
    p.stop()
```

---

### Q6. How do you generate Playwright reports?
**Answer:**
Use Allure or HTML reports.

```bash
pytest --alluredir=reports/allure-results
allure serve reports/allure-results
```

Or native Playwright HTML reports:
```bash
pytest --html=report.html --self-contained-html
```

---

### Q7. How would you design a scalable test automation framework?
**Answer:**
- Use Page Object Model structure  
- Centralize config (YAML/JSON)  
- Reuse fixtures for setup  
- Use markers and CI integration  
- Separate test data and logic  
- Include logging, screenshots, and reporting

---

### Q8. Explain headless vs headed execution in Playwright.
**Answer:**
- **Headless:** runs without GUI (faster, used in CI).  
- **Headed:** visible browser for debugging.

```python
browser = p.chromium.launch(headless=False)
```

---

### Q9. How do you handle authentication in Playwright tests?
**Answer:**
Save login state once and reuse it across tests.

```python
context = browser.new_context()
page = context.new_page()
# login manually
context.storage_state(path="auth.json")
```

Then reuse in other tests:
```python
context = browser.new_context(storage_state="auth.json")
```

---

### Q10. Best practices for test stability and speed.
**Answer:**
- Prefer locators over selectors  
- Use context reuse  
- Avoid hard waits (`time.sleep`)  
- Use parallel execution wisely  
- Clean up data after tests  
- Use retry logic for flaky UI tests
