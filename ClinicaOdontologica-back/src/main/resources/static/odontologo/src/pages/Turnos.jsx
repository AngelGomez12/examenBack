import React, { useState } from 'react'
import { Header } from '../components/Header'
import { FormTurno } from '../components/FormTurno'
import { getTurnos } from '../service/TurnoService'
import { CardsTurnos } from '../components/CardsTurnos'
import { deleteTurno } from '../service/TurnoService'

export const Turnos = () => {

    const [turnos, setTurnos] = useState([])
    const fetchTurnos = () => {
        getTurnos()
            .then((data) => {
                setTurnos(data);
                console.log(data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const deleteTurnoById = (id) => {
        deleteTurno(id)
            .then(() => {
                const updatedTurnos = turnos.filter((turno) => turno.id !== id);
                setTurnos(updatedTurnos);
            })
            .catch((error) => {
                console.error(error);
            });
    }
    return (
        <div>
            <Header />
            <div className='flex flex-col gap-4 items-center w-full'>
                <h1>Turnos</h1>
                <FormTurno fetchTurnos={fetchTurnos} />
                <CardsTurnos turnos={turnos} fetchTurnos={fetchTurnos} deleteTurnoById={deleteTurnoById} />
            </div>
        </div>
    )
}
