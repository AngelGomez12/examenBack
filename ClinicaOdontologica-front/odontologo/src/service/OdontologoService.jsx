import axios from 'axios';
const API_URL = import.meta.env.VITE_API_URL;

let odontologos = null;
let odontologoDetails = null;

export async function getOdontologos() {
  try {
    if (odontologos) {
      return odontologos;
    }
    const response = await axios.get(`${API_URL}/odontologos`);
    odontologos = response.data;
    return odontologos;
  } catch (error) {
    console.error(error);
  }
}

export async function getOdontologoById(id) {
  try {
    if (odontologoDetails && odontologoDetails.id === id) {
      return odontologoDetails;
    }
    const response = await axios.get(`${API_URL}/odontologos/${id}`);
    odontologoDetails = response.data
    return response.data;
  } catch (error) {
    console.error(error);
  }
}
