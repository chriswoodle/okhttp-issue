const morgan = require('morgan')
const express = require('express')
const app = express()
const port = 8080

app.use(morgan(':method :url :status :res[content-length] - :response-time ms'));

app.post('/', (req, res) => {
    console.log('request started...');
    res.send('Hello World!')
})


app.post('/late', (req, res) => {
    console.log('request started...');
    req.setTimeout(10 * 60 * 1000);
    setTimeout(() => {
        res.send('Hello World!')
    }, 1.5 * 60 * 1000)
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})
