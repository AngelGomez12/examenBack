import axios from 'axios';
const API_URL = import.meta.env.VITE_API_URL;

let turnos = null;

export async function getTurnos() {
    try {
        if (turnos) {
            return turnos;
        }
        const response = await axios.get(`${API_URL}/turnos`);
        turnos = response.data;
        return turnos;
    } catch (error) {
        console.error(error);
    }
}

export async function createTurno(turno) {
    try {
        const response = await axios.post(`${API_URL}/turnos/saveTurno`, turno);
        turnos = null;
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

export async function deleteTurno(id) {
    try {
        const response = await axios.delete(`${API_URL}/turnos/delete/${id}`);
        turnos = null;
        return response.data;
    } catch (error) {
        console.error(error);
    }
}