import React, { useEffect, useState } from 'react'
import { getOdontologos } from '../service/OdontologoService'
import { Link } from 'react-router-dom'

export const Cards = (props) => {

    useEffect(() => {
        let isMounted = true;
        props.fetchOdontologos();
        return () => {
            isMounted = false;
        };
    }, [props.odontologos]);

    return (
        <div >
            <ul className='flex flex-wrap gap-2'>
                {props.odontologos.map((odontologo) => {
                    return (
                        <div key={odontologo.id} className='flex flex-col bg-slate-950 text-white mb-3 w-48 h-32'>
                            <div className='flex gap-2'>
                                <li>{odontologo.name}</li>
                                <li>{odontologo.lastName}</li>
                            </div>
                            <li>{odontologo.matricula}</li>
                            <Link to={`/details/${odontologo.id}`}>Detalles</Link>
                        </div>
                    )
                }
                )}
            </ul>
        </div>
    )
}
