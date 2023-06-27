import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import MainScreen from "./mainScreen/MainScreen";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from 'axios';

class App extends Component {
    // componentDidMount() {
    //     axios.get("http://localhost:8080/api/data") // 백엔드 서버 주소
    //         .then(res => {
    //             console.log(res.data);
    //         })
    //         .catch(err => {
    //             console.log(err);
    //         });
    // }

    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<MainScreen />}></Route>
                        <Route path="/postViewPage/:user"></Route>
                    </Routes>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
