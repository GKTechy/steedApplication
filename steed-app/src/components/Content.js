import React, { Component } from 'react'
import {BrowserRouter as Router,Switch,Route,Link} from "react-router-dom";

import Login from './Login'

import AdminMaster from './admin/AdminMaster';
import AdminTransaction from './admin/AdminTransaction';
export class Content extends Component {
    render() {
        return (
            <div className="content-wrapper">
                <Route exact path="/adminMaster" component={AdminMaster} />
                <Route exact path="/adminTransaction" component={AdminTransaction} />

                <Route path="/login" component={Login} />
                
                
            </div>
        )
    }
}

export default Content
