import React, { useEffect, useState } from 'react'
import { getOdontologos } from '../service/OdontologoService'
import { Link } from 'react-router-dom'

export const Cards = () => {

    const [odontologos, setOdontologos] = useState([])
    useEffect(() => {
        // getOdontologos()
        getOdontologos()
            .then((data) => {
                setOdontologos(data);
                console.log(data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, [])

    return (
        <div>
            <ul>
                {odontologos.map((odontologo) => {
                    return (
                        <div key={odontologo.id}>
                            <li>{odontologo.name}</li>
                            <li>{odontologo.lastName}</li>
                            <li>{odontologo.matricula}</li>
                            <Link to={`/details/${odontologo.id}`}>Detalles</Link>
                        </div>
                    )
                }
                )}
            </ul></div>
    )
}
