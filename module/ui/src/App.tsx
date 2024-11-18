import React, {useEffect, useState} from 'react';

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.js.map';
import 'primereact/resources/primereact.min.css';
import 'primereact/resources/themes/md-dark-deeppurple/theme.css';
import {Book} from "./model/Book";
import {Card} from "primereact/card";

function App() {

  const [books, setBooks] = useState<Book[]>([]);

  useEffect(() => {
    fetch(process.env.REACT_APP_EXPLORER_HOST + '/books')
    .then(response => response.json())
    .then(data => setBooks(data));
  }, []);

  return (
      <div className="App">
        <div className={'container-fluid'}>
          <div className={'row'}>
            {books.map(book => {
                  return (
                      <div className={"col-sm"}>
                        <Card className={'card'}>
                          <h2>
                            {book.title}
                          </h2>
                        </Card>
                      </div>
                  )
                }
            )}
          </div>
        </div>
      </div>
  );
}

export default App;
