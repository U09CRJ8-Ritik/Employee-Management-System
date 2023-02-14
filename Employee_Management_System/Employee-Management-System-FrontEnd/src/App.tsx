import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import EmployeeListComponent from './components/Employee/EmployeeListComponent';
import PostEmployeeComponent from './components/Employee/PostEmployeeComponent';
import HeaderComponent from './components/Header/HeaderComponent';
import LoginComponent from './components/Login/LoginComponent';

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route index element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />}></Route>
          <Route path="/employee" element={<EmployeeListComponent />}></Route>
          <Route path="*" element={<EmployeeListComponent />}></Route>
          <Route path="/addEmployee" element={<PostEmployeeComponent />}></Route>
          <Route path="/updateEmployee/:id" element={<PostEmployeeComponent />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
