import { useEffect, useState } from 'react'
import './App.css'
import ProductList from "./productList.jsx";
import CategoryFilter from './CategoryFilter.jsx';




function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(()=>{
    fetch("http://localhost:8080/api/products")
      .then(response=>response.json())
      .then(data=>setProducts(data));

    fetch("http://localhost:8080/api/categories")
      .then(response=>response.json())
      .then(data=>setCategories(data));

  },[]);

  const handleSearchChange=(event)=>{
    setSearchTerm(event.target.value)
  }
  const handleSortChange=(event)=>{
    setSortOrder(event.target.value)
  }
  const handleCategorySelect=(categoryId)=>{
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  }

  const filteredProducts=products
    .filter(product=>{
      return( 
        (selectedCategory ? product.category.id===selectedCategory :true)
        &&
        product.name.toLowerCase().includes(searchTerm.toLowerCase())
    )}).sort((a,b)=>{
      if (sortOrder=="asc") {
        return a.price-b.price;
      }else{
        return b.price-a.price;
      }
    })


  return (
    <div className='container'>
      <h1 className='my-4' >Product Catalog</h1>
      <div className='row aling-items-center mb-4'>
        <div className='col-md-3 col-sm-4 mb-2 '>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>
        <div className='col-md-3 col-sm-4 mb-2 '>
          <input type='text'
          className='form-control'
          placeholder='Search for products'
          onChange={handleSearchChange}/>
        </div>
        <div className='col-md-3 col-sm-4 mb-2 '>
          <select className='form-control' name="" id="" 
          onChange={handleSortChange}>
            <option value="asc">Search for price : Low to High</option>
            <option value="desc">Search for price : High to Low</option>
          </select>
        </div>


      </div>
      <div>
        {
          filteredProducts.length ? (
            // display products
            <ProductList products={filteredProducts}/>
          ):(
            <p>No Products</p>
          )
        }
      </div>
    </div>
  )
}

export default App
