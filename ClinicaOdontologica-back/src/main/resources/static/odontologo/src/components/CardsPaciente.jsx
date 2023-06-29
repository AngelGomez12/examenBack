import React, { useEffect } from 'react'

export const CardsPaciente = (props) => {

    useEffect(() => {
        props.fetchPacientes();

    }, [props.pacientes])

    return (
        <div>
            <ul className='flex flex-wrap gap-2'>
                {props.pacientes.map((paciente) => {
                    return (
                        <div key={paciente.id} className='flex flex-col bg-slate-950 text-white mb-3 w-56 h-64 rounded'>
                            <h1 className='text-xl ml-3'>Paciente</h1>
                            <div className='flex gap-2 ml-3'>
                                <li className='text-xl'>{paciente.name}</li>
                                <li className='text-xl'>{paciente.lastName}</li>
                            </div>
                            <div>
                                <li className='text-xl'>{paciente.DNI}</li>
                                <li className='text-xl'>{paciente.email}</li>
                                <li className='text-xl'>{paciente.fechaIngreso}</li>
                            </div>
                            <div className='flex'>
                                <li className='ml-3'>Domicilio:{paciente.domicilio.numero}</li>
                                <li className='ml-3'>{paciente.domicilio.calle}</li>
                            </div>
                            <div className='flex'>
                                <li className='ml-3'>{paciente.domicilio.localidad}</li>
                                <li className='ml-3'>{paciente.domicilio.provincia}</li>
                            </div>
                            <div className='flex gap-2 ml-5 mt-3'>
                                <button className=' bg-blue-400 rounded-sm pl-2 pr-2'>Editar</button>
                                <button className=' bg-red-400 rounded-sm pl-2 pr-2' >Eliminar</button>
                            </div>
                        </div>
                    )
                })}
            </ul>
        </div>
    )
}
