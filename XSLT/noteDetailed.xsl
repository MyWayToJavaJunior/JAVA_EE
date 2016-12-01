<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : noteDetailed.xsl
    Created on : 11 Ноябрь 2015 г., 15:30
    Author     : user
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">


    <xsl:template match="/">
        <html>
            <head>
                 <title>
                     <xsl:value-of select="note/subject"/>
                 </title>
            </head>
            <body>
                <h1>
                    <xsl:value-of select="note/subject"/>
                </h1>
                To: <xsl:value-of select="note/to"/> <br/>
                From: <xsl:value-of select="note/from"/> <br/>
                <xsl:value-of select="note/body"/>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
