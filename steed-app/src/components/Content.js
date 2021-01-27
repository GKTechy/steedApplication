import React, { Component } from 'react'
import ManageUsers from './admin/ManageUsers'
import Roles from './admin/Roles'
import {BrowserRouter as Router,Switch,Route,Link} from "react-router-dom";

import Login from './Login'
import UserRoleMapping from './admin/UserRoleMapping';
import NoteForApproval from './admin/NoteForApproval';
import Master from './admin/Master';
export class Content extends Component {
    render() {
        return (
            <div className="content-wrapper">
                <Route exact path="/adminMaster" component={Master} />

                <Route exact path="/manageusers" component={ManageUsers} />
                <Route path="/roles" component={Roles} />
                <Route path="/userrolemapping" component={UserRoleMapping} />
                <Route path="/noteforapproval" component={NoteForApproval} />
                <Route path="/login" component={Login} />
                
                
            </div>
        )
    }
}

export default Content
