import React from 'react'
import "../styles/LandingPage.css"
import { Link } from 'react-router-dom'
const LandingPage = () => {
  return (
    <div>
      <div className="landingpage">
        <div className="landing">
          <div className="user">
            <Link to="/userlogin">
                    <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHoAAAB6CAMAAABHh7fWAAAAY1BMVEUAAAD///8WFhbo6Oj8/Pz4+PgSEhLl5eUODg6/v7+oqKiZmZlHR0fMzMy4uLjFxcXw8PCGhoYvLy8lJSVtbW16enqgoKBdXV0cHBzX19dSUlLf399iYmKxsbGSkpI0NDQ9PT080IWaAAAFvUlEQVRogcWb17aqMBRF4yEISO8Civz/V16CjZKyEnDc9SxMU9gtO+T030QMnrETJ4wulT+pukShk9i/R9tW7JdtdnXJTO41a0s/tjT5OugkTtucCJW3aZz8Ap14pQT7wZceTAfRYQpwX/Q0PA5t3wOU+1RwR5ZdjbarTA/MlFVquAptV/BML5Ur4XI09TSneq7Ao+borjAHMxWdKfp+3Ucm5Ho3Qlv1XjBTbemj4yPATLEmmvpHkQnxBbuNj07K48iElHzbykU77ZFkQloHRTvDsWRCBh6bg3YMDKdKGYe9RTu7v2aerlv2Bu0Y2myV8g17jbZ2GG25grVxWaHtnVZbpsKWotPfkQlJZejLL8mEXMToBn+L25ZVFHtV2v5psBsRmsKbu4i+ttGK8f2RUwEaXehy8efZbMHwlI8G3WQQczxRPIDsmIdOsC+64LshCxx48H38i8Y8dCmMM8Hl8rfo7ow8mEoiXMzHnz+h4gd9Q54rZOFtggVztzU6RJ56iGO8aeIGiP1Oyd5o6B/LQlumCELXSzQ06FaVythYYBUu0NBKewoyOuzbHO0gT2Tq5NF6QGxnhu6RB0olGf3A+i/ahvxGBKCxGc/tD9qDHlg7DZ5At+t90JD9zZH6jIX53eKNTlz1j8cwHqmP2Ng+c5MXGlugASCf6AC9a9o3DI1tSwhtg+jyiU6wScqQtU7AGOuRTOgQWmryx00XV4Js0yg3nNAV+HOkCAj5AqZqQqNpfAWg0WGwxSZoTDbz8WJRuPQzxmhEI6lVLzaeQ4xJL9EoFfVKNOSGnopHNJ5nuaph6+TmlxGtUaYq5UVPqlN38ke0zu/lfvOCGYjXMEa0TqHqIXOcoVYppB3RmBl9PyCu9XZaLyKPE6F6BaOryKY1Onk2exElFEp4ZuKuN9WuR5wN0KTYLjieYO9Dk2vZLL6yptScbHP0qNZvLJueaGI1vlkt1xg9Kg/qWx0Y1xb3oHfqP6MNp+zv0dZFwaZcx3x+lVNy0q3HXh9FWoWdw7YZO0a3uibqS9npMlfBaEih/PatvKgah5ML0KSLUq1B3Ea0RkW2rRpZCuJ4BT72dESjkdy1DOXumsm6oEOvRvQd+mXWI2E4m3oPCw3vIxpyOSkInuDRoH7hX8OCYfUBT4uk1jMl6qArY8GwrZqg/KJe47Ua1XdTU5Z9KCJY3SE/ZSsG3k+Jjzy9FlSC1YqkFjqa0NL0QxH/yiRL/diJG5HX+Hw1QSzJCSUrPLKqgnhZ1KmOVJ2QzYbE0MIkbcdsPxWK1rJ5oW2B8buZ7rCvBKYysF9owYxn0tYOTJTvnKYtNKH5FRBV9RsSv3DgfNBcn30z6Zzbipe+P+sTTzSvSGpkxDjiDMuboek2VUNK0JC238+DztCceOGAPfbSZtivUtQLvfGcQLkIVbwKWd9lx/eJz/r7OmR7P7U2G2/j/EavDgJ4zRzGWnrl/P3lfE73lnZHea6ko+WrP/P5QS+Dldte6z3X4tOtP4P6nuQuCsQH7rLlPnO/BZHZ0fnc3Ab7PcdX82LH7Nh+hk6G2U/KzjpK89h4SLjoZUTj/h2l+Vvn9adFc8hPG2KYFk0xy5aYQzoZxapPYvTxTW5zrRreVj1IenVOPeWrQuO66Qs7bjPSusy4aXWDD050tTm12Tb4HdhBOtc2meC0NWocYODiJBO8Zs4fjJuXQHFbWA9fb+7pHL9xNzr0G8v5RyaCduXwwDbWh+DgQNSknRzWNtyK/K+4Nf2gjS7OkyUN+eEB3ayB5ORZdhcg6c2Kvh+5vSzYkV++CHd50Vp+2K64ckLvxls9uyuiWuVFG6N7NtBNG+B6kX0fdMEDcr8IulRFNRpkRxW8TlND9CirAm1MW8kbEPXR49A7v1aY9rz2Ozxj0ro2SC2vv2XcWtg1u/WepZWpaV+WZAcsVV8E2dmddM6Coq+iLtFOEE3uab7+w0vGL/gHB4hJBvefKrwAAAAASUVORK5CYII=" alt="" />
                    <h2>User Login</h2>
                </Link>
            </div>
            <div className="merchant">
              <Link to="/merchantlogin">
                <img src="data:image/png;base64,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" alt="" />
                <h2>Merchant Login</h2>
              </Link>
            </div>
        </div>
      </div>
    </div>
  )
}

export default LandingPage
