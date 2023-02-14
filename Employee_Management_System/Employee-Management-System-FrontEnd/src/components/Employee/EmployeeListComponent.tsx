import React, { useState, useEffect } from "react"
import EmployeeService from "../../services/EmployeeService";
import './EmployeeListComponent.css'
import { Link, useNavigate } from "react-router-dom";


const EmployeeList = () => {

    const [initialEmployeeList, finalEmployeeList] = useState([]);
    const navigate = useNavigate();


    const getAllEmployees = () => {
        EmployeeService.getAllEmployees().then((response) => {
            finalEmployeeList(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    useEffect(() => {
        getAllEmployees();
    }, [])


    const deleteEmployeeHandler = (id: number) => {
        EmployeeService.deleteEmployee(id).then(response => {
            getAllEmployees();
        }).catch(error => console.log(error));
    }

    const logOutHandler=()=>{
        navigate('/login')
    }

    return (
        <div>
            <button className="button-logout" onClick={logOutHandler}>Log Out</button>
            <h1 className="App" >Employees List</h1>        
            <Link to="/addEmployee" className="button-add right">Add Employee</Link>
            <div className="emp-list">
                <table id="employee">
                    <thead>
                        <th >Id</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Date Of Birth</th>
                        <th>Date Of Joining</th>
                        <th>Years Of Experience</th>
                        <th>Update/Delete</th>
                    </thead>
                    <tbody>
                        {
                            initialEmployeeList.map(
                                (employee: any) =>
                                    <tr>
                                        <td>{employee.id}</td>
                                        <td>{employee.name}</td>
                                        <td>{employee.designation}</td>
                                        <td>{employee.dateOfBirth}</td>
                                        <td>{employee.dateOfJoining}</td>
                                        <td>{employee.yearsOfExperience}</td>
                                        <td>
                                            <Link className="button-update" to={`/updateEmployee/${employee.id}`} >Update</Link>
                                            <button className="button-delete" onClick={() => deleteEmployeeHandler(employee.id)}>Delete</button>
                                        </td>
                                    </tr>
                            )
                        }

                    </tbody>

                </table>

            </div>

        </div>
    )
};

export default EmployeeList;
