import React, { useState } from "react";
import UsuarioLogin from "../../Models/UsuarioLogin";
import { fetchUserBack } from "../../Services/ClientService";
import "./Login.css";
interface LoginProps {
    onLogin: (username: string, password:string) => void;
}
const Login: React.FC<LoginProps> = ({onLogin}) => {
    const [nome, setUsername] = useState("");
    const [senha, setPassword] = useState("");
    const user: UsuarioLogin = {nome: nome, senha: senha};
    
    const handleLogin= () => {
            user.nome = nome;
             user.senha = senha;
        // Chame a função fetchUser com o nome de usuário (username) como argumento
        fetchUserBack(user)
          .then((response) => {
            // Verifique se a resposta tem dados e se a senha corresponde
            if (response.data && response.data.nome == nome && response.data.senha === senha) {
                onLogin(nome, senha);
            } else {
              console.log("else");  
              alert("Usuário ou senha inválidos");
            }
            
          })
          .catch((error) => {
            console.log("error");
            console.error("Erro ao fazer login:", error);
            alert("Ocorreu um erro ao fazer login. Por favor, tente novamente mais tarde.");
          });
    };
    return (
        <div className="LoginForm">
            <div className="LoginInputs">
                <label className="userLabel">Usuário</label>
                <input
                    type="text"
                    value={nome}
                    onChange={(e) => setUsername(e.target.value)}/>
                <label className="senhaLabel">Senha</label>
                <input
                    type="password"
                    value={senha}
                    onChange={(e) => setPassword(e.target.value)}/>
            </div>
            <button className="buttonMargin" onClick={handleLogin}>Entrar</button>
        </div>
    );
};

export default Login;