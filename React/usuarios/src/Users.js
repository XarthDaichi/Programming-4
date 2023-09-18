import React, { useState } from 'react';
import './Users.css';

function Users() {
    const [ users, setUsers ] = useState([]);
    
    const dispatchUserEvent = (actionType, payload) => {
        switch (actionType) {
            case 'ADD_USER':
                setUsers([...users, payload.newUser]);
                return;
            case 'REMOVE_USER':
                setUsers(users.filter(user => user.id !== payload.userId));
                return;
            default:
                return;
        }
    };

    return (
        <div className="Users">
            <h3>Users</h3>
            <AddUser dispatchUserEvent={dispatchUserEvent }/>
            <UserList users={users } dispatchUserEvent={dispatchUserEvent}/>
        </div>
    );
}

const UserList = ({users,dispatchUserEvent}) => {
    return (
        <div className="UserList">
            {users.map(user => <User key={user.id} user={user}
                            dispatchUserEvent={dispatchUserEvent}/>)}
        </div>
    );
};

const User = ({ user,dispatchUserEvent }) => {
    const handleRemoveUser = () => {
        dispatchUserEvent('REMOVE_USER', { userId: user.id });
    };
    return (
        <div className="User">
            <h3>{user.name}</h3>
            <h4>{user.age}</h4>
            <button onClick={handleRemoveUser}>Delete user</button>
        </div>
    );
};

const AddUser = ({dispatchUserEvent}) => {
    const [ name, setName ] = useState('');
    const [ age, setAge ] = useState('');

    const handleAddUser = () => {
        const user = { id: Math.random(), name, age};
        dispatchUserEvent('ADD_USER', {newUser: user});
    };

    return (
        <div className="AddUser">
            <input type="text" value={name} onChange={e => setName(e.target.value)} placeholder="name"/>
            <br />
            <input type="text" value={age} onChange={e => setAge(e.target.value)} placeholder="age"/>
            <br />
            <button onClick={handleAddUser}>Add User</button>
        </div>
    );
};

export default Users;