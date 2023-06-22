import React, { useState } from 'react'
import { Cards } from '../components/Cards'
import { Header } from '../components/Header'
import { Form } from '../components/Form'
import { getOdontologos } from '../service/OdontologoService'
import { deleteOdontologo } from '../service/OdontologoService'

const Home = () => {
  const [odontologos, setOdontologos] = useState([])

  const fetchOdontologos = () => {
    getOdontologos()
      .then((data) => {
        setOdontologos(data);
        console.log(data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  const deleteOdontologoId = (id) => {
    deleteOdontologo(id)
      .then(() => {
        const updatedOdontologos = odontologos.filter((odontologo) => odontologo.id !== id);
        setOdontologos(updatedOdontologos);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div>
      <Header />
      <div className='pt-2 flex flex-col items-center'>
        <Form fetchOdontologos={fetchOdontologos} />
        <Cards fetchOdontologos={fetchOdontologos} odontologos={odontologos} deleteOdontologoId={deleteOdontologoId} />
      </div>
    </div>
  )
}

export default Home
