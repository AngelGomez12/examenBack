import React from 'react'
import { Link } from 'react-router-dom/dist'

export const Header = () => {
    return (
        <div className='flex justify-center items-center gap-4 text-2xl bg-black text-white h-14'>
            <Link className='hover:underline' to="/">Odontologos</Link>
            <Link className='hover:underline' to="/pacientes">Pacientes</Link>
            <Link className='hover:underline' to="/turnos">Turnos</Link>
        </div>
    )
}
