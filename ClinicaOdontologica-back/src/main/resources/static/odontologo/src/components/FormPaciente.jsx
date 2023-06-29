import React from 'react'

export const FormPaciente = () => {
    return (
        <div className='flex items-center w-full justify-center'>
            <form className='flex flex-col gap-2 bg-black w-1/4 justify-center items-center'>
                <h3 className='text-white'>Crear Paciente</h3>
                <div className='flex gap-6'>
                    <div className='flex flex-col gap-6'>
                        <input className='text-black w-36' type="text" placeholder='Nombre' />
                        <input className='text-black w-36' type="text" placeholder='Apellido' />
                        <input className='text-black w-36' type="text" placeholder='DNI' />
                        <input className='text-black w-36' type="text" placeholder='Email' />
                        <input className='text-black w-36' type="text" placeholder='Fecha de Ingreso' />
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
