import React from 'react'
import { createPaciente } from '../service/PacienteService'

export const FormPaciente = (props) => {

    const handleSubmit = (e) => {
        e.preventDefault();
        const body = {
            name: e.target[0].value,
            lastName: e.target[1].value,
            DNI: e.target[2].value,
            email: e.target[3].value,
            fechaIngreso: e.target[4].value,
            domicilio: {
                numero: e.target[5].value,
                calle: e.target[6].value,
                localidad: e.target[7].value,
                provincia: e.target[8].value,
            },
        }

        createPaciente(body).then((data) => {
            console.log(data);
            props.fetchPacientes();
        }).catch((error) => {
            console.error(error);
        })
    }

    return (
        <div className='flex items-center w-full justify-center'>
            <form onSubmit={handleSubmit} className='flex flex-col gap-2 bg-black w-1/4 justify-center items-center'>
                <h3 className='text-white'>Crear Paciente</h3>
                <div className='flex gap-6'>
                    <div className='flex flex-col gap-6'>
                        <input className='text-black w-36' type="text" placeholder='Nombre' />
                        <input className='text-black w-36' type="text" placeholder='Apellido' />
                        <input className='text-black w-36' type="text" placeholder='DNI' />
                        <input className='text-black w-36' type="text" placeholder='Email' />
                        <input className='text-black w-36' type="date" placeholder='Fecha de Ingreso' />

                        <h3>Domicilio:</h3>
                    </div>
                    <div className='flex flex-col gap-6'>
                        <input className='text-black w-36' type="text" placeholder='Numero' />
                        <input className='text-black w-36' type="text" placeholder='Calle' />
                        <input className='text-black w-36' type="text" placeholder='Localidad' />
                        <input className='text-black w-36' type="text" placeholder='Provincia' />
                    </div>
                </div>
                <button type='submit' className='bg-blue-100 w-20'>Enviar</button>
            </form>
        </div>
    )
}
