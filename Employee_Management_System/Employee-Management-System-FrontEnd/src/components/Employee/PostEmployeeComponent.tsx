import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import EmployeeService from '../../services/EmployeeService';
import './PostEmployeeComponent.css';


const PostEmployee = () => {

    const [name, setName] = useState<string>('');
    const [designation, setDesignation] = useState<string>('');
    const [dateOfBirth, setDateOfBirth] = useState<string>('');
    const [dateOfJoining, setDateOfJoining] = useState<string>('');
    const navigate = useNavigate();
    const { id } = useParams();


    const nameChangeHandler = (event: any) => {
        setName(event.target.value);
    }
    const designationChangeHandler = (event: any) => {
        setDesignation(event.target.value);
    }
    const dateOfBirthChangeHandler = (event: any) => {
        setDateOfBirth(event.target.value);
    }
    const dateOfJoiningChangeHandler = (event: any) => {
        setDateOfJoining(event.target.value);
    }


    const saveUpdateEmployee = (event: any) => {

        event.preventDefault();

        const employee = { name, designation, dateOfBirth, dateOfJoining };

        if (id) {
            EmployeeService.updateEmployee(id, employee).then((response) => {
                navigate('/employee');
            }).catch((error) => {
                console.log(error);
            })
        }
        else {
            EmployeeService.addEmployee(employee).then((response) => {
                navigate('/employee')

            }).catch((error) => {
                console.log(error);
            })
        }
    }

    useEffect(() => {
        EmployeeService.getEmployeeById(id).then((response) => {
            setName(response.data.name)
            setDesignation(response.data.designation)
            setDateOfBirth(response.data.dateOfBirth)
            setDateOfJoining(response.data.dateOfJoining)
            console.log("use Effect Called")
        }).catch(error => console.log(error))
    }, [])


    const onSaveHandler = (event: any) => {
        saveUpdateEmployee(event);
    }

    const onCancelHandler = (event: any) => {
        navigate('/employee')
    }

    const title = () => {
        if (id) {
            return <h2 className="App text">Update Employee</h2>
        } else {
            return <h2 className="App text">Add Employee</h2>
        }
    }

    return (
        <div className="container">
            {title()}
            <div>
                <form>
                    <div className="row">
                        <label>Name</label>
                        <div>
                            <input type="text" placeholder="Enter Name" name="Name" className="form-control" value={name} onChange={nameChangeHandler} />
                        </div>
                    </div >
                    <div className="row">
                        <label>Designation</label>
                        <div>
                            <input type="text" placeholder="Enter Designation" name="designation" className="form-control" value={designation} onChange={designationChangeHandler} />
                        </div>
                    </div>
                    <div className="row">
                        <label>Date Of Birth</label>
                        <div>
                            <input type="text" placeholder="YYYY-MM-DD" name="dateOfBirth" className="form-control" value={dateOfBirth} onChange={dateOfBirthChangeHandler} />
                        </div>
                    </div>
                    <div className="row">
                        <label>Date Of Joining</label>
                        <div>
                            <input type="text" placeholder="YYYY-MM-DD" name="dateOfJoining" className="form-control" value={dateOfJoining} onChange={dateOfJoiningChangeHandler} />
                        </div>
                    </div>
                    <button className="button-save margintop" onClick={onSaveHandler} >Save Employee</button>
                    <button className="button-cancel margintop marginLeft" onClick={onCancelHandler} >Cancel</button>
                </form>

            </div>
        </div>

    )
}

export default PostEmployee
