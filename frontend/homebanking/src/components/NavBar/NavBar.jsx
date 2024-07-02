import React from 'react';
import './NavBar.css';

const NavBar = () => {
  return (
    <div className="nav-container">
      <nav className="nav">
        <ul className="nav__list">
          <li className="nav__item">
            <a href="#" className="nav__link" tabIndex="0">
              {/* Icono de Home */}
              <img src="/icons/Home.svg" alt="Home" className="nav__icon" />
              <span className="nav__text">inicio</span>
            </a>
          </li>

          <li className="nav__item">
            <a href="#" className="nav__link" tabIndex="0">
              {/* Icono de Home */}
              <img src="/icons/Home.svg" alt="Home" className="nav__icon" />
              <span className="nav__text">inicio</span>
            </a>
          </li>
          
          <li className="nav__item">
            <a href="#" className="nav__link" tabIndex="0">
              {/* Icono de Transactions */}
              <img src="/icons/Transactions.svg" alt="Movimientos" className="nav__icon" />
              <span className="nav__text">Transactions</span>
            </a>
          </li>
          <li className="nav__item">
            <a href="#" className="nav__link" tabIndex="0">
              {/* Icono de Settings */}
              <img src="/icons/Settings.svg" alt="Settings" className="nav__icon" />
              <span className="nav__text">Settings</span>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default NavBar;


