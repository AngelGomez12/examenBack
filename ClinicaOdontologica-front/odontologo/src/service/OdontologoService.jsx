import axios from 'axios';
const API_URL = import.meta.env.VITE_API_URL;

export async function getOdontologos() {
  try {
    const response = await axios.get(`${API_URL}/odontologos`);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

export async function getOdontologoById(id) {
  try {
    const response = await axios.get(`${API_URL}/odontologos/${id}`);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
  }
}
