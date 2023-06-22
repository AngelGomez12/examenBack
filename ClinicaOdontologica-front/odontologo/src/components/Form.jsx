import React, { useState } from 'react'
import { createOdontologo } from '../service/OdontologoService';

export const Form = (props) => {

    const [error, setError] = useState('');
    const handleSubmit = (e) => {
        e.preventDefault();
        const name = e.target[0].value;
        const lastName = e.target[1].value;
        const matricula = e.target[2].value;

        if (!name || !lastName || !matricula) {
            setError('Por favor, completa todos los campos');
            return;
        }

        createOdontologo({ name, lastName, matricula }).then((data) => {
            console.log(data);
            props.fetchOdontologos();
        }).catch((error) => {
            console.error(error);
        });
        e.target.reset();
    }




    return (
        <div className='flex flex-col bg-black text-white w-1/2 h-40 mb-5 items-center'>
            <h1>Formulario</h1>
            <form onSubmit={handleSubmit} className='gap-5 p-3'>
                <input className='text-black' type="text" />
                <input className='text-black' type="text" />
                <input className='text-black' type="text" />
                {error && <p className="text-red-500">{error}</p>}
                <button type='submit'>Enviar</button>
            </form>
        </div>
    )
}