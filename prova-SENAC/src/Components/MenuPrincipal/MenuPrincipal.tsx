import React from "react";
import "./MenuPrincipal.css";
import Login from "../Login/Login";

interface MenuPrincipalProps {
  name: string;
  logoUrl: string;
}

const MenuPrincipal: React.FC<MenuPrincipalProps> = ({ name, logoUrl }) => {
  const handleLogin = (username: string, password: string) => {
    alert(`Login efetuado com sucesso! Usuário: ${username}`);
  };
  return (
    <div className="menu_bar">
      <div className="menu_container">
        <div className="menu_logo">
          <img className="logox" src={logoUrl} alt="Logo" />
        </div>
        <div className="menu_name">
          <h1 className="namex">{name}</h1>
        </div>
        <Login
          onLogin={handleLogin}></Login>
      </div>
    </div>
  );
};

export default MenuPrincipal;