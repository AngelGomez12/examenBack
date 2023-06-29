import axios from 'axios';
const API_URL = import.meta.env.VITE_API_URL;


let pacientes = null;

export async function getPacientes() {
    try {
        if (pacientes) {
            return pacientes;
        }
        const response = await axios.get(`${API_URL}/pacientes`);
        pacientes = response.data;
        return pacientes;
    } catch (error) {
        console.error(error);
    }
};