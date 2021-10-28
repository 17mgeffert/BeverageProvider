import React from "react"
import ReactMultiSelectCheckboxes from 'react-multiselect-checkboxes';

import options from "./data"

const MultiSelect = () => {
  return <ReactMultiSelectCheckboxes options={options}/>
}

export default MultiSelect;