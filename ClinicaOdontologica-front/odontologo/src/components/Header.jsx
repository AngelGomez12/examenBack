import React from 'react'
import { Link } from 'react-router-dom/dist'

export const Header = () => {
    return (
        <div>
            <Link to="/">Odontologos</Link>
            <Link to="/pacientes">Pacientes</Link>
            <Link to="/turnos">Turnos</Link>
        </div>
    )
}
