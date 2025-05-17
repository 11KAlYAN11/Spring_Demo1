import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CustomerList = () => {
    const [customers, setCustomers] = useState([]);
    const [newCustomer, setNewCustomer] = useState({ name: '', age: '' });
    const [editingCustomer, setEditingCustomer] = useState(null);

    useEffect(() => {
        fetchCustomers();
    }, []);

    const fetchCustomers = async () => {
        try {
            const response = await axios.get('/customers');
            setCustomers(response.data);
        } catch (error) {
            console.error('Error fetching customers:', error);
        }
    };

    const handleInputChange = (e, setter) => {
        const { name, value } = e.target;
        setter(prev => ({ ...prev, [name]: value }));
    };

    const addCustomer = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/customers', newCustomer);
            setNewCustomer({ name: '', age: '' });
            fetchCustomers();
        } catch (error) {
            console.error('Error adding customer:', error);
        }
    };

    const startEditing = (customer) => {
        setEditingCustomer({ ...customer });
    };

    const updateCustomer = async (e) => {
        e.preventDefault();
        try {
            await axios.put(`/customers/${editingCustomer.id}`, editingCustomer);
            setEditingCustomer(null);
            fetchCustomers();
        } catch (error) {
            console.error('Error updating customer:', error);
        }
    };

    const deleteCustomer = async (id) => {
        try {
            await axios.delete(`/customers/${id}`);
            fetchCustomers();
        } catch (error) {
            console.error('Error deleting customer:', error);
        }
    };

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-3xl font-bold text-center mb-6">Customer Management</h1>

            {/* Add Customer Form */}
            <div className="bg-white p-4 rounded shadow mb-6">
                <h2 className="text-xl font-semibold mb-4">Add New Customer</h2>
                <form onSubmit={addCustomer} className="flex flex-col gap-4">
                    <input
                        type="text"
                        name="name"
                        value={newCustomer.name}
                        onChange={(e) => handleInputChange(e, setNewCustomer)}
                        placeholder="Name"
                        className="p-2 border rounded"
                        required
                    />
                    <input
                        type="number"
                        name="age"
                        value={newCustomer.age}
                        onChange={(e) => handleInputChange(e, setNewCustomer)}
                        placeholder="Age"
                        className="p-2 border rounded"
                        required
                    />
                    <button type="submit" className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600">
                        Add Customer
                    </button>
                </form>
            </div>

            {/* Customer List */}
            <div className="bg-white p-4 rounded shadow">
                <h2 className="text-xl font-semibold mb-4">Customer List</h2>
                <table className="w-full border-collapse">
                    <thead>
                    <tr className="bg-gray-200">
                        <th className="border p-2">ID</th>
                        <th className="border p-2">Name</th>
                        <th className="border p-2">Age</th>
                        <th className="border p-2">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {customers.map(customer => (
                        <tr key={customer.id} className="border-b">
                            <td className="border p-2">{customer.id}</td>
                            <td className="border p-2">
                                {editingCustomer && editingCustomer.id === customer.id ? (
                                    <input
                                        type="text"
                                        name="name"
                                        value={editingCustomer.name}
                                        onChange={(e) => handleInputChange(e, setEditingCustomer)}
                                        className="p-1 border rounded w-full"
                                    />
                                ) : (
                                    customer.name
                                )}
                            </td>
                            <td className="border p-2">
                                {editingCustomer && editingCustomer.id === customer.id ? (
                                    <input
                                        type="number"
                                        name="age"
                                        value={editingCustomer.age}
                                        onChange={(e) => handleInputChange(e, setEditingCustomer)}
                                        className="p-1 border rounded w-full"
                                    />
                                ) : (
                                    customer.age
                                )}
                            </td>
                            <td className="border p-2 flex gap-2">
                                {editingCustomer && editingCustomer.id === customer.id ? (
                                    <>
                                        <button
                                            onClick={updateCustomer}
                                            className="bg-green-500 text-white px-2 py-1 rounded hover:bg-green-600"
                                        >
                                            Save
                                        </button>
                                        <button
                                            onClick={() => setEditingCustomer(null)}
                                            className="bg-gray-500 text-white px-2 py-1 rounded hover:bg-gray-600"
                                        >
                                            Cancel
                                        </button>
                                    </>
                                ) : (
                                    <>
                                        <button
                                            onClick={() => startEditing(customer)}
                                            className="bg-yellow-500 text-white px-2 py-1 rounded hover:bg-yellow-600"
                                        >
                                            Edit
                                        </button>
                                        <button
                                            onClick={() => deleteCustomer(customer.id)}
                                            className="bg-red-500 text-white px-2 py-1 rounded hover:bg-red-600"
                                        >
                                            Delete
                                        </button>
                                    </>
                                )}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default CustomerList;