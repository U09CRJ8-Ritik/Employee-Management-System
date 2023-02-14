import axios from 'axios'

const employeeUrl = "http://localhost:8080/employee"

class EmployeeService {
    getAllEmployees() {
        return axios.get(employeeUrl);
    }

    addEmployee(employee: object) {
        return axios.post(employeeUrl, employee);
    }


    getEmployeeById(id: string | undefined) {
        return axios.get(employeeUrl + '/' + id);
    }

    updateEmployee(id: string, employee: any) {
        return axios.put(employeeUrl + '/' + id, employee);
    }

    deleteEmployee(id: number) {
        return axios.delete(employeeUrl + '/' + id);
    }
}


export default new EmployeeService();