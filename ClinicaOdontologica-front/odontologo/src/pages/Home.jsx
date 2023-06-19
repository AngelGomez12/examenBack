import React from 'react'
import { Cards } from '../components/Cards'
import { Header } from '../components/Header'

const Home = () => {
  return (
    <div>
      <Header />
      <div className='pt-2'>
        <Cards />
      </div>
    </div>
  )
}

export default Home
