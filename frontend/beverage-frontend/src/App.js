import React, {useState} from 'react';
import logo from './logo.svg';
import './App.css';

import MultiSelect from "./MultiSelect";
import MultiSelectAll from "./MultiSelectAll";

function App() {

  let [text, setText] = useState("text");

  return (
    <div className="App">
      <header className="App-header">
        <div>
        <h1> Beverage Provider </h1>
        <p>
          The Beverage Provider Application allows you to select from a list of standard bar ingredients
          and will present you with a unique cocktail for you to try today. Make it a party game or have some
          fun by yourself. Either way, make it a good night with a fun new drink to try.
        </p>
            <div className="App">
              <MultiSelect />
              <br />
              <MultiSelectAll />
            </div>

<div>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React {text}
        </a>
        <input value={text} onChange={(e) => setText(e.target.value)} />
        </div>
        </div>
      </header>
    </div>
  );
}

export default App;
