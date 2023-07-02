import React, { useEffect } from 'react'

export const CardsTurnos = (props) => {

    useEffect(() => {
        props.fetchTurnos();
    }, [props.turnos])
    return (
        <>
            <ul className='flex flex-wrap gap-2'>
                {props.turnos && props.turnos.map((turno) => {
                    return (
                        <div key={turno.id} className='flex flex-col bg-slate-950 text-white mb-3 w-48 h-32 rounded'>
                            <h1 className='text-xl ml-3'>Turno</h1>
                            <div className='flex gap-2 ml-3'>
                                <li className='text-xl'>Domicilio:{turno.name}</li>
                                <li className='text-xl'>{turno.lastName}</li>
                            </div>
                            <li className='ml-3'>Matricula:{turno.matricula}</li>
                            <div className='flex gap-2 ml-5 mt-3'>
                                <button className=' bg-blue-400 rounded-sm pl-2 pr-2'>Editar</button>
                                <button className=' bg-red-400 rounded-sm pl-2 pr-2' onClick={() => props.deleteTurnoById(turno.id)}>Eliminar</button>
                            </div>
                        </div>
                    )
                }) || <h1>No hay turnos</h1>}
            </ul>
        </>
    )
}
