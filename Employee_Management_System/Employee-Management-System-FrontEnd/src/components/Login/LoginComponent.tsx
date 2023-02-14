import React, { useState } from 'react'
import { useNavigate } from 'react-router'
import './LoginComponent.css'

const LoginComponent = () => {

    const [username, setUserName] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate()

    const userNameChangeHandler = (event: any) => {
        setUserName(event.target.value);
    }
    const passwordChangeHandler = (event: any) => {
        setPassword(event.target.value);
    }

    const onLogInHandler = (event: any) => {
        event.preventDefault();
        if (username === 'ritik' && password === 'abc') {
            navigate('/employee')
        }
        else if (username === 'ankit' && password === 'xyz') {
            navigate('/employee')
        }
        else {
            alert("Invalid Credentials")
        }
    }

    return (
        <div>
            <div className="container">
                <h3 className="App text">Enter Login Credentials</h3>
                <form>
                    <div className="row">
                        <label>UserName</label>
                        <div>
                            <input type="text" placeholder="Enter UserName" name="UserName" value={username} onChange={userNameChangeHandler} className="form-control" />
                        </div>
                    </div>
                    <div className="row">
                        <label>Password</label>
                        <div>
                            <input type="password" placeholder="Enter Password" name="Password" value={password} onChange={passwordChangeHandler} className="form-control" />
                        </div>
                    </div>
                    <button className="button-login margintop" onClick={onLogInHandler} >Login</button>
                </form>
            </div>
        </div>
    )
}

export default LoginComponent
