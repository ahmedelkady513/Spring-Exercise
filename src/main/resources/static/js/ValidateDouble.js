function validateEmployeeSalary() {
  let salary = document.forms["employeeForm"]["salary"].value;
  let regex = /^[0-9]*\.?[0-9]+$/;

  if (!regex.test(salary)) {
    alert("Salary Value Must Be Double");
    return false;
  }

  return true;
}
