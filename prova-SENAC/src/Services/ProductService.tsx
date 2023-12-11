/* eslint-disable @typescript-eslint/no-explicit-any */
// apiService.js
import axios, {AxiosResponse} from 'axios';
import Product from '../Models/Product';

const BASE_URL = 'api/produto';

interface Item {
    id: number;
    name: string;
    description?: string;
}

const apiClient = axios.create({
  baseURL: BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

const apiService = {
    fetchItems(): Promise<AxiosResponse<Item[]>> {
      return apiClient.get<Item[]>('/items');
    },

    // fetchUsuarioLogin(UsuarioLogin: UsuarioLogin): Promise<AxiosResponse<UsuarioLogin>> {
    //   return apiClient.post<UsuarioLogin>(`/login`, UsuarioLogin);
    // },
    
    fetchItemById(id: number): Promise<AxiosResponse<Item>> {
      return apiClient.get<Item>(`/items/${id}`);
    },

    createItem(data: Item): Promise<AxiosResponse<Item>> {
      return apiClient.post<Item>('/items', data);
    },
  
    updateItem(id: number, data: Partial<Item>): Promise<AxiosResponse<Item>> {
      return apiClient.put<Item>(`/items/${id}`, data);
    },
  
    deleteItem(id: number): Promise<AxiosResponse<void>> {
      return apiClient.delete(`/items/${id}`);
    }    
  };
  
export default apiService;

  export const fetchProductById = (id: number): Promise<AxiosResponse<any>> => {
    return apiClient.get<Product>(`http://localhost:8080/produto/buscaId/${id}`);
  }

  