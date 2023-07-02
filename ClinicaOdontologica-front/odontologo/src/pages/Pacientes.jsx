import React, { useState } from 'react'
import { Header } from '../components/Header'
import { FormPaciente } from '../components/FormPaciente'
import { getPacientes } from '../service/PacienteService'
import { CardsPaciente } from '../components/CardsPaciente'

export const Pacientes = () => {
    const [pacientes, setPacientes] = useState([])

    const fetchPacientes = () => {
        getPacientes()
            .then((data) => {
                setPacientes(data);
                console.log(data);
            })
            .catch((error) => {
                console.error(error);
            });
    }


    return (
        <div>
            <Header />
            <div className='flex flex-col gap-4 items-center w-full'>
                <h1>Pacientes</h1>
                <FormPaciente fetchPacientes={fetchPacientes} />
                <CardsPaciente pacientes={pacientes} fetchPacientes={fetchPacientes} />
            </div>
        </div>
    )
}
