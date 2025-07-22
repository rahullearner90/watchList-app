export default function ProductList({ products }) {
    return (
        <div className="row">
            {products.map((p) => (
                <div className="col-lg-4 col-md-4 col-sm-12 mb-4" key={p.id}>
                    <div className="card h-100">
                        <img
                            className="card-img-top"
                            alt={p.name}
                            src={p.imageUrl || "https://placehold.co/600x400"}
                        />
                        <div className="card-body">
                            <h5 className="card-title">{p.name}</h5>
                            <p className="card-text">{p.description}</p>
                            <p className="card-text">
                                <strong>${p.price}</strong>
                            </p>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}
