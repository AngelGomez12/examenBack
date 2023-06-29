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

export async function createPaciente(paciente) {
    try {
        const response = await axios.post(`${API_URL}/pacientes/newPaciente`, paciente);
        pacientes = null;
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

export async function deletePaciente(id) {
    try {
        const response = await axios.delete(`${API_URL}/pacientes/delete/${id}`);
        pacientes = null;
        return response.data;
    } catch (error) {
        console.error(error);
    }
}