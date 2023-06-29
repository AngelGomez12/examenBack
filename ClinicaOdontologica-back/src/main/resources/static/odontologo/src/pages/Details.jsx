import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom/dist';
import { getOdontologoById } from '../service/OdontologoService';
import { Header } from '../components/Header';

function Details() {
    const { id } = useParams();
    const [odontologo, setOdontologo] = useState({});
    useEffect(() => {
        let isMounted = true;
        getOdontologoById(id).then((data) => {
            setOdontologo(data);
            console.log(data);
        }).catch((error) => {
            console.error(error);
        });
        return () => {
            isMounted = false;
        };
    }, [id]);

    return (
        <div>
            <Header />
            <h1>Detalles</h1>
            <h2>{odontologo.name}</h2>
            <h2>{odontologo.lastName}</h2>
            <h2>{odontologo.matricula}</h2>
            <button>Eliminar</button>
            <button>Editar</button>
        </div>
    );
}

export default Details;