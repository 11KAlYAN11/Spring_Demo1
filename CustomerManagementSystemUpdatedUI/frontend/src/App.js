import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import CustomerList from './components/CustomerList';

function App() {
  return (
      <div className="min-h-screen bg-gray-100">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/customers" element={<CustomerList />} />
        </Routes>
      </div>
  );
}

export default App;