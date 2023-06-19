import React, { useEffect, useState } from 'react'
import { getOdontologos } from '../service/OdontologoService'
import { Link } from 'react-router-dom'

export const Cards = () => {

    const [odontologos, setOdontologos] = useState([])
    useEffect(() => {
        let isMounted = true; // Variable de estado para verificar si el componente aún está montado

        getOdontologos()
            .then((data) => {
                if (isMounted) {
                    setOdontologos(data);
                    console.log(data);
                }
            })
            .catch((error) => {
                console.error(error);
            });

        return () => {
            isMounted = false; // Marcar el componente como desmontado al limpiar el efecto
        };
    }, []);

    return (
        <div >
            <ul className='flex gap-2'>
                {odontologos.map((odontologo) => {
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
