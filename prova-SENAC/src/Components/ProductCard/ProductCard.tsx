import React from 'react';
import { useNavigate } from 'react-router-dom';
import './ProductCard.css';

interface ProductCardProps {
  image: string;
  description: string;
  whereToGo: string;
  cardTitle: string;
  id: string;
}

const ProductCard: React.FC<ProductCardProps> = ({ image, description, whereToGo, cardTitle, id }) => {
  const navigate = useNavigate();
  const handleDetailsClick = () => {
    // Navegar para a rota desejada com o ID
    navigate(`/mostraProduto/${id}`);
  };

  return (
    <div className="card card-extra-styles">
      <h2 className="card-title">{cardTitle}</h2>
      <img src={image} className="product-card__image" alt="Product" />
      <div className="card-body">        
        <p className="card-text">{description}</p>
        <button className="btn btn-primary">{whereToGo}</button><br />
        <form onSubmit={handleDetailsClick}>
          <input type="hidden" name="id" value={id} />
          <button type='submit' className="btn btn-primary">Detalhes</button>
        </form>
      </div>
    </div>
  );
};

export default ProductCard;
