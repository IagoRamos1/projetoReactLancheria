// MostraProduto.tsx
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { fetchProductById } from '../../Services/ProductService';
import Logo from '../../assets/logotipo.png';
import MenuPrincipal from '../MenuPrincipal/MenuPrincipal';
import './ShowProduct.css';

const ShowProduct = () => {
  const { id } = useParams<{ id: any }>();
  const [productData, setProductData] = useState<any | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  useEffect(() => {
    fetchProductById(id)
      .then((response) => {
        setProductData(response.data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message || 'Something went wrong');
        setLoading(false);
      });
  }, [id]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <>
      <MenuPrincipal name='Lancheria' logoUrl={Logo} />

      <div className="detalhes-produto-container">
        <img
          className="imagem-produto"
          src={productData.img}
          alt={productData.img}
        />
        <div className="informacoes-produto">
          <h2>{productData.nome}</h2>
          <p>Descrição: {productData.descricao}</p>
          {/* Adicione aqui os outros detalhes do produto */}
          <h3>Valor: {productData.preco} reais</h3>
          <button onClick={() => history.back()} className="botao-voltar">
          Voltar
        </button>
        </div>
      </div>
    </>
  );
};

export default ShowProduct;
