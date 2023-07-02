import React, { useState } from 'react'
import { createTurno } from '../service/TurnoService'

export const FormTurno = (props) => {

    const [error, setError] = useState('');
    const handleSubmit = (e) => {
        e.preventDefault();
        const body = {
            pacienteId: e.target[0].value,
            odontologoId: e.target[1].value,
            fechaIngreso: new Date(e.target[2].value).toISOString(),
        };

        if (!body.pacienteId || !body.odontologoId || !body.fechaIngreso) {
            setError('Por favor, completa todos los campos');
            return;
        }

        createTurno(body).then((data) => {
            console.log(data);
            props.fetchTurnos();
        }).catch((error) => {
            console.error(error);
        });
    }
    return (
        <div className='flex flex-col bg-black text-white w-1/2 h-40 mb-5 items-center'>
            <h2>Crear Turno</h2>
            <form onSubmit={handleSubmit} className='gap-5 p-3'>
                <input className='text-black' type="text" placeholder='PacienteId' />
                <input className='text-black' type="text" placeholder='OdontologoId' />
                <input className='text-black' type="date" placeholder='Fecha de ingreso' />
                {error && <p className="text-red-500">{error}</p>}
                <button type='submit'>Enviar</button>
            </form>
        </div>
    )
}
