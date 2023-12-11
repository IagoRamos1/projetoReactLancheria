import Logo from '../../assets/logotipo.png';
import './AdminPage.css';
import MenuPrincipal from '../../Components/MenuPrincipal/MenuPrincipal';

const AdminPage = () => {
    return (
        <MenuPrincipal name='Teste de Rota' logoUrl={Logo} />
    )
}

export default AdminPage;
