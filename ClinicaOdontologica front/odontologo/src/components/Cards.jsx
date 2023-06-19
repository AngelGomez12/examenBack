import React, { useEffect, useState } from 'react'
import { getOdontologos } from '../service/OdontologoService'

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
                        </div>
                    )
                }
                )}
            </ul></div>
    )
}
