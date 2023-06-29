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

export async function createOdontologo(odontologo) {
  try {
    const response = await axios.post(`${API_URL}/odontologos/newOdontologo`, odontologo);
    odontologos = null;
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

export async function deleteOdontologo(id) {
  try {
    const response = await axios.delete(`${API_URL}/odontologos/delete/${id}`);
    odontologos = null;
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

export async function updateOdontologo(id, odontologo) {
  try {
    const response = await axios.put(`${API_URL}/odontologos/update/${id}`, odontologo);
    odontologos = null;
    return response.data;
  } catch (error) {
    console.error(error);
  }
}
