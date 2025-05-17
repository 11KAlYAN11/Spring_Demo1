import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div className="text-center py-10">
            <h2 className="text-3xl font-bold mb-4">Welcome to the Customer Management System!</h2>
            <p className="text-lg mb-6">Please explore customer management features.</p>
            <Link to="/customers" className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
                Go to Customers
            </Link>
        </div>
    );
};

export default Home;