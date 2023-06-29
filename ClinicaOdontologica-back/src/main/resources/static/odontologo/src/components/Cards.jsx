import React, { useEffect, useState } from 'react'
import { deleteOdontologo } from '../service/OdontologoService';

export const Cards = (props) => {

    useEffect(() => {
        let isMounted = true;
        props.fetchOdontologos();
        return () => {
            isMounted = false;
        };
    }, [props.odontologos]);

    return (
        <>
            <ul className='flex flex-wrap gap-2'>
                {props.odontologos.map((odontologo) => {
                    return (
                        <div key={odontologo.id} className='flex flex-col bg-slate-950 text-white mb-3 w-48 h-32 rounded'>
                            <h1 className='text-xl ml-3'>Odontologo</h1>
                            <div className='flex gap-2 ml-3'>
                                <li className='text-xl'>{odontologo.name}</li>
                                <li className='text-xl'>{odontologo.lastName}</li>
                            </div>
                            <li className='ml-3'>Matricula:{odontologo.matricula}</li>
                            <div className='flex gap-2 ml-5 mt-3'>
                                <button className=' bg-blue-400 rounded-sm pl-2 pr-2'>Editar</button>
                                <button className=' bg-red-400 rounded-sm pl-2 pr-2' onClick={() => props.deleteOdontologoId(odontologo.id)}>Eliminar</button>
                            </div>
                        </div>
                    )
                }
                )}
            </ul>
        </>
    )
}
